<template>
  <div class="operadoras-container">
    <h1 class="title">Busca de Operadoras de Saúde</h1>
    
    <SearchBar 
      v-model="termoBusca"
      @search="buscarOperadoras"
    />
    
    <LoadingSpinner v-if="carregando" />
    
    <div v-else>
      <div v-if="resultados.length" class="results-container">
        <div class="results-header">
          <span class="results-count">{{ totalResults }} resultado(s) encontrado(s)</span>
          <div class="pagination-info">
            Página {{ paginaAtual }} de {{ totalPages }}
          </div>
        </div>
        
        <div class="operadoras-list">
          <OperadoraCard 
            v-for="operadora in resultados" 
            :key="operadora.Registro_ANS"
            :operadora="operadora"
          />
        </div>
        
        <PaginationControls
          :current-page="paginaAtual"
          :total-pages="totalPages"
          @page-changed="mudarPagina"
        />
      </div>
      
      <NoResults 
        v-else
        :search-term="termoBusca"
      />
    </div>
  </div>
</template>

<script>
import { buscarOperadorasAPI } from '../services/api'
import SearchBar from '../components/SearchBar.vue'
import OperadoraCard from '../components/OperadoraCard.vue'
import PaginationControls from '../components/PaginationControls.vue'
import LoadingSpinner from '../components/LoadingSpinner.vue'
import NoResults from '../components/NoResults.vue'
import _ from 'lodash'

export default {
  components: {
    SearchBar,
    OperadoraCard,
    PaginationControls,
    LoadingSpinner,
    NoResults
  },
  data() {
    return {
      termoBusca: '',
      resultados: [],
      paginaAtual: 1,
      perPage: 10,
      totalResults: 0,
      carregando: false
    }
  },
  computed: {
    totalPages() {
      return Math.ceil(this.totalResults / this.perPage)
    }
  },
  methods: {
    buscarOperadoras: _.debounce(function() {
      if (this.termoBusca.length < 3 && this.termoBusca !== '') return
      
      this.carregando = true
      
      buscarOperadorasAPI(this.termoBusca, this.paginaAtual, this.perPage)
        .then(response => {
          this.resultados = response.data.results
          this.totalResults = response.data.total_results
        })
        .catch(error => {
          console.error('Erro na busca:', error)
          this.resultados = []
          this.totalResults = 0
        })
        .finally(() => {
          this.carregando = false
        })
    }, 500),
    
    mudarPagina(novaPagina) {
      if (novaPagina >= 1 && novaPagina <= this.totalPages) {
        this.paginaAtual = novaPagina
        window.scrollTo({ top: 0, behavior: 'smooth' })
        this.buscarOperadoras()
      }
    }
  },
  watch: {
    termoBusca() {
      this.paginaAtual = 1
      this.buscarOperadoras()
    }
  },
  mounted() {
    this.buscarOperadoras()
  }
}
</script>

<style scoped>

.operadoras-container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 2rem 1rem;
}

.title {
  text-align: center;
  margin-bottom: 2rem;
}

.results-container {
  background-color: white;
  border-radius: var(--border-radius);
  box-shadow: var(--box-shadow);
  padding: 1.5rem;
  margin-bottom: 2rem;
}

.results-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 1.5rem;
  padding-bottom: 0.5rem;
  border-bottom: 1px solid var(--medium-gray);
}

.operadoras-list {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
  gap: 1.5rem;
  margin-bottom: 2rem;
}

@media (max-width: 768px) {
  .operadoras-list {
    grid-template-columns: 1fr;
  }
  
  .results-header {
    flex-direction: column;
    align-items: flex-start;
    gap: 0.5rem;
  }
}

@media (max-width: 480px) {
  .title {
    font-size: 1.5rem;
  }
}
</style>
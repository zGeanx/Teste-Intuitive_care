<template>
  <div class="no-results">
    <img src="https://cdn-icons-png.flaticon.com/512/4076/4076478.png" alt="Nenhum resultado" class="no-results-image">
    <h3>Nenhum resultado encontrado</h3>
    <p v-if="searchTerm.length >= 3">Tente ajustar sua busca ou usar termos diferentes.</p>
    <p v-else>Digite pelo menos 3 caracteres para iniciar a busca.</p>
  </div>
</template>

<script>
export default {
  name: 'NoResults',
  props: {
    searchTerm: {
      type: String,
      default: ''
    }
  }
}
</script>

<style scoped>
.no-results {
  text-align: center;
  padding: 3rem 1rem;
  background-color: var(--text-light);
  border-radius: var(--border-radius);
  box-shadow: var(--box-shadow);
}

.no-results-image {
  width: 100px;
  height: 100px;
  margin-bottom: 1rem;
  opacity: 0.7;
}

.no-results h3 {
  color: var(--primary-color);
  margin-bottom: 0.5rem;
}

.no-results p {
  color: var(--dark-gray);
}
</style>
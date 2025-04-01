<template>
  <div class="pagination-controls">
    <button 
      @click="emitPageChange(paginaAtual - 1)" 
      :disabled="paginaAtual <= 1"
      class="pagination-button prev"
    >
      &larr; Anterior
    </button>
    <div class="page-numbers">
      <span 
        v-for="page in visiblePages" 
        :key="page"
        @click="emitPageChange(page)"
        :class="{ active: page === paginaAtual }"
        class="page-number"
      >
        {{ page }}
      </span>
      <span v-if="showEllipsis" class="ellipsis">...</span>
    </div>
    <button 
      @click="emitPageChange(paginaAtual + 1)" 
      :disabled="paginaAtual >= totalPages"
      class="pagination-button next"
    >
      Próxima &rarr;
    </button>
  </div>
</template>

<script>
export default {
  name: 'PaginationControls',
  props: {
    currentPage: {
      type: Number,
      required: true
    },
    totalPages: {
      type: Number,
      required: true
    },
    maxVisiblePages: {
      type: Number,
      default: 5
    }
  },
  computed: {
    paginaAtual() {
      return this.currentPage
    },
    visiblePages() {
      const range = []
      const half = Math.floor(this.maxVisiblePages / 2)
      let start = Math.max(1, this.paginaAtual - half)
      let end = Math.min(this.totalPages, start + this.maxVisiblePages - 1)
      
      if (end - start < this.maxVisiblePages - 1) {
        start = Math.max(1, end - this.maxVisiblePages + 1)
      }
      
      for (let i = start; i <= end; i++) {
        range.push(i)
      }
      
      return range
    },
    showEllipsis() {
      return this.totalPages > this.maxVisiblePages && 
             Math.max(...this.visiblePages) < this.totalPages
    }
  },
  methods: {
    emitPageChange(page) {
      if (page >= 1 && page <= this.totalPages) {
        this.$emit('page-changed', page)
      }
    }
  }
}
</script>

<style scoped>
.pagination-controls {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 1rem;
  margin-top: 2rem;
}

.pagination-button {
  padding: 0.5rem 1rem;
  background-color: var(--accent-color);
  color: var(--text-light);
  border: none;
  border-radius: var(--border-radius);
  cursor: pointer;
  transition: var(--transition);
  font-weight: 500;
}

.pagination-button:hover:not(:disabled) {
  background-color: #2980b9;
}

.pagination-button:disabled {
  background-color: var(--medium-gray);
  cursor: not-allowed;
  opacity: 0.6;
}

.page-numbers {
  display: flex;
  gap: 0.5rem;
}

.page-number {
  padding: 0.5rem 0.8rem;
  border-radius: var(--border-radius);
  cursor: pointer;
  transition: var(--transition);
}

.page-number:hover {
  background-color: var(--medium-gray);
}

.page-number.active {
  background-color: var(--accent-color);
  color: var(--text-light);
  font-weight: 500;
}

.ellipsis {
  padding: 0.5rem;
  align-self: flex-end;
}

@media (max-width: 768px) {
  .pagination-controls {
    flex-direction: column;
    gap: 0.5rem;
  }
  
  .page-numbers {
    order: -1;
  }
}
</style>
<template>
  <div class="operadora-card">
    <div class="operadora-header">
      <h2>{{ operadora.Razao_Social }}</h2>
      <span class="fantasy-name" v-if="operadora.Nome_Fantasia">{{ operadora.Nome_Fantasia }}</span>
      <span class="no-fantasy-name" v-else>Sem nome fantasia</span>
    </div>
    <div class="operadora-location">
      <span class="city">{{ operadora.Cidade }}</span>
      <span class="state">{{ operadora.UF }}</span>
    </div>
    <div class="operadora-footer">
      <span class="registry">Registro ANS: {{ operadora.Registro_ANS }}</span>
    </div>
  </div>
</template>

<script>
export default {
  name: 'OperadoraCard',
  props: {
    operadora: {
      type: Object,
      required: true
    }
  }
}
</script>

<style scoped>
.operadora-card {
  border: 1px solid var(--medium-gray);
  border-radius: var(--border-radius);
  padding: 1.5rem;
  transition: var(--transition);
  background-color: var(--light-gray);
}

.operadora-card:hover {
  transform: translateY(-3px);
  box-shadow: var(--box-shadow);
}

.operadora-header {
  margin-bottom: 1rem;
}

.operadora-header h2 {
  font-size: 1.2rem;
  color: var(--primary-color);
  margin-bottom: 0.5rem;
}

.fantasy-name {
  display: inline-block;
  background-color: var(--secondary-color);
  color: var(--text-light);
  padding: 0.2rem 0.5rem;
  border-radius: 4px;
  font-size: 0.8rem;
  font-weight: 500;
}

.no-fantasy-name {
  display: inline-block;
  background-color: var(--dark-gray);
  color: var(--text-light);
  padding: 0.2rem 0.5rem;
  border-radius: 4px;
  font-size: 0.8rem;
  font-weight: 500;
}

.operadora-location {
  display: flex;
  gap: 0.5rem;
  margin-bottom: 1rem;
  color: var(--dark-gray);
}

.city {
  font-weight: 500;
}

.state {
  background-color: var(--primary-color);
  color: var(--text-light);
  padding: 0.1rem 0.5rem;
  border-radius: 4px;
  font-size: 0.8rem;
}

.operadora-footer {
  font-size: 0.8rem;
  color: var(--dark-gray);
}

@media (max-width: 480px) {
  .operadora-card {
    padding: 1rem;
  }
}
</style>
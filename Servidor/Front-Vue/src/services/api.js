import axios from 'axios'

const api = axios.create({
  baseURL: 'http://127.0.0.1:5000'
})

export const buscarOperadorasAPI = (termo, page = 1, perPage = 10) => {
  return api.get('/buscar', {
    params: {
      q: termo,
      page,
      per_page: perPage
    }
  })
}
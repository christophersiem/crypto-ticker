import axios from 'axios'

export const getMain = () => {
  return axios.get('/api/coins').then(res => res.data)
}

export const getById = coinId => {
  return axios.get(`api/coins/${coinId}`).then(res => res.data)
}

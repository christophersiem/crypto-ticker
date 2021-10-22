import axios from 'axios'
import { useEffect, useState } from 'react'

export default function useCoins() {
  const [coins, setCoins] = useState([])
  useEffect(() => {
    axios
      .get('/api/coins')
      .then(res => res.data)
      .then(setCoins)
      .catch(error => console.error(error.message))
  }, [])

  return coins
}

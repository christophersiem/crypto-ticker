import { useEffect, useState } from 'react'
import { toast } from 'react-toastify'
import { getById, getMain } from '../service/coin-service'

export default function useCoins() {
  const [coins, setCoins] = useState([])

  const getStandardCoins = () => {
    getMain()
      .then(setCoins)
      .catch(error => toast(error.message))
  }

  useEffect(() => {
    getStandardCoins()
  }, [])

  const getCoinById = coinId => {
    getById(coinId)
      .then(data => setCoins([data, ...coins]))
      .catch(error => toast(error.message))
  }

  const isInList = coinId => {
    return coins.some(coin => coin.id === coinId.trim().toLowerCase())
  }

  return { coins, setCoins, getCoinById, getStandardCoins, isInList }
}

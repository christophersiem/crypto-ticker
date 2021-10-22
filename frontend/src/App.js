import CryptoCard from './components/CryptoCard'

function App() {
  const bitcoinData = {
    name: 'Bitcoin',
    currentPrice: {
      eur: 10000,
      usd: 20000,
    },
  }

  return (
    <div>
      <h1>Crypto Ticker</h1>
      <CryptoCard coinData={bitcoinData} />
    </div>
  )
}

export default App

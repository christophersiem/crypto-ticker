import CryptoCard from './components/CryptoCard'
import Header from './components/Header'
import styled from 'styled-components/macro'

export default function App() {
  const bitcoinData = {
    name: 'Bitcoin',
    currentPrice: {
      eur: 10000,
      usd: 20000,
    },
    imageUrl:
      'https://assets.coingecko.com/coins/images/279/small/ethereum.png?1595348880',
  }

  return (
    <PageLayout>
      <Header />
      <CryptoCard coinData={bitcoinData} />
    </PageLayout>
  )
}

const PageLayout = styled.div`
  position: fixed;
  height: 100%;
  width: 100%;
  top: 0;
  left: 0;
`

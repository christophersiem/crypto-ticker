import Header from './components/Header'
import styled from 'styled-components/macro'
import CryptoOverview from './components/CryptoOverview'
import useCoins from './hooks/useCoins'

export default function App() {
  const coins = useCoins()

  return (
    <PageLayout>
      <Header />
      <CryptoOverview coins={coins} />
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

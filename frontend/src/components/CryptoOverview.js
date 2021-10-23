import CryptoCard from './CryptoCard'
import styled from 'styled-components/macro'
import LoadingSpinner from './LoadingSpinner'

export default function CryptoOverview({ coins }) {
  if (coins.length === 0) {
    return <LoadingSpinner />
  }

  return (
    <Wrapper>
      {coins.map(coin => (
        <CryptoCard key={coin.id} coinData={coin} />
      ))}
    </Wrapper>
  )
}

const Wrapper = styled.div`
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(300px, 450px));
  grid-gap: 10px;
`

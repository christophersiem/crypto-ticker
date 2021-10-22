import styled from 'styled-components/macro'

export default function CryptoCard({ coinData }) {
  return (
    <Wrapper>
      <CoinHeader>
        <h2>{coinData.name}</h2>
        <img src={coinData.imageUrl} alt={''} />
      </CoinHeader>
      <CoinData>
        <p>{coinData.currentPrice.eur} €</p>
        <p>{coinData.currentPrice.usd} $</p>
      </CoinData>
    </Wrapper>
  )
}

const Wrapper = styled.div`
  border: 2px solid white;
  padding: var(--spacing-m);
  margin: var(--spacing-s);
`

const CoinHeader = styled.section`
  display: flex;
  justify-content: space-around;
`

const CoinData = styled.section``

import styled from 'styled-components/macro'
import { convertToReadableDate } from '../service/date-service'

export default function CryptoCard({ coinData }) {
  return (
    <Wrapper>
      <CardHeader>
        <h2>{coinData.name}</h2>
        <Image src={coinData.imageUrl} alt={''} />
      </CardHeader>
      <CardData>
        <p>{coinData.currentPrice.eur} €</p>
        <p>{coinData.currentPrice.usd} $</p>
      </CardData>
      <CardInfo>
        Last updated: {convertToReadableDate(coinData.lastUpdated)}
      </CardInfo>
    </Wrapper>
  )
}

const Wrapper = styled.div`
  border: 2px solid ${({ theme }) => theme.text};
  padding: var(--spacing-m);
  margin: var(--spacing-s);
`

const CardHeader = styled.section`
  display: flex;
  justify-content: space-around;
  align-items: center;
  font-size: 1.3em;
`

const Image = styled.img`
  height: 100%;
`

const CardData = styled.section`
  display: grid;
  justify-content: center;

  p {
    font-size: 1.6em;
    text-align: center;
    margin: var(--spacing-s);
  }
`

const CardInfo = styled.p`
  font-size: 0.8em;
  margin-top: 20px;
  margin-bottom: 0;
  text-align: end;
`

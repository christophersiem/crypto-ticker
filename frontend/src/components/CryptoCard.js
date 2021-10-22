import styled from 'styled-components/macro'

export default function CryptoCard({ coinData }) {
  return <Wrapper>{coinData.name}</Wrapper>
}

const Wrapper = styled.div`
  border: 1px solid black;
  padding: var(--spacing-m);
`

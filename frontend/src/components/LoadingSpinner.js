import { RingLoader } from 'react-spinners'
import styled from 'styled-components/macro'

export default function LoadingSpinner() {
  return (
    <Wrapper>
      <RingLoader size={100} loading={true} color={'white'} />
      <p>Loading Data ...</p>
    </Wrapper>
  )
}

const Wrapper = styled.div`
  margin-top: 50px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;

  p {
    font-size: 1.4em;
  }
`

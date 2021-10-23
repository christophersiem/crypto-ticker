import styled from 'styled-components/macro'

export default function CryptoSearch() {
  return (
    <Form>
      <Input type={'text'} placeholder={'e.g. Cardano'} />
      <Button>Search</Button>
    </Form>
  )
}

const Form = styled.form`
  display: flex;
  justify-content: center;
  margin: var(--spacing-s);
  gap: var(--spacing-s);
`

const Input = styled.input`
  flex-grow: 2;
  padding: var(--spacing-s);
  max-width: 400px;
  border-radius: 5px;
`

const Button = styled.button`
  //flex-grow: 1;
`

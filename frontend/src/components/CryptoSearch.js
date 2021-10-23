import styled from 'styled-components/macro'
import { useState } from 'react'
import { toast } from 'react-toastify'
import 'react-toastify/dist/ReactToastify.css'

export default function CryptoSearch({ getCoinById, isInList }) {
  const [coin, setCoin] = useState('')

  const handleSubmit = event => {
    event.preventDefault()

    if (isInList(coin)) {
      toast(`${coin} is already in your list :)`)
      setCoin('')
      return
    }
    getCoinById(coin.toLowerCase())
    setCoin('')
  }

  return (
    <Form onSubmit={handleSubmit}>
      <Input
        type={'text'}
        required
        placeholder={'e.g. Cardano'}
        onChange={event => setCoin(event.target.value)}
        value={coin}
      />
      <Button>Add</Button>
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

const Button = styled.button``

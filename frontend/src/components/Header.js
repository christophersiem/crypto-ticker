import styled from 'styled-components/macro'
import DarkModeToggle from 'react-dark-mode-toggle'

export default function Header({ theme, setTheme }) {
  const toggleTheme = () => {
    theme === 'light' ? setTheme('dark') : setTheme('light')
  }

  return (
    <Wrapper>
      <Heading>Crypto Ticker</Heading>
      <DarkModeToggle
        onChange={toggleTheme}
        checked={theme === 'dark'}
        size={60}
      />
    </Wrapper>
  )
}

const Wrapper = styled.div`
  display: flex;
  margin: var(--spacing-s);
  align-items: center;
`

const Heading = styled.h1`
  text-align: center;
  flex-grow: 2;
`

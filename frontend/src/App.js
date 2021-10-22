import Header from './components/Header'
import styled from 'styled-components/macro'
import CryptoOverview from './components/CryptoOverview'
import useCoins from './hooks/useCoins'
import React, { useState } from 'react'
import { darkTheme, lightTheme } from './Theme'
import { ThemeProvider } from 'styled-components'
import { GlobalStyle } from './GlobalStyle'

export default function App() {
  const [theme, setTheme] = useState('dark')
  const coins = useCoins()

  return (
    <ThemeProvider theme={theme === 'light' ? lightTheme : darkTheme}>
      <GlobalStyle />
      <PageLayout>
        <Header theme={theme} setTheme={setTheme} />
        <CryptoOverview coins={coins} />
      </PageLayout>
    </ThemeProvider>
  )
}

const PageLayout = styled.div`
  position: fixed;
  height: 100%;
  width: 100%;
  top: 0;
  left: 0;
`

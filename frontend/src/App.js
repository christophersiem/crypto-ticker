import Header from './components/Header'
import styled from 'styled-components/macro'
import CryptoOverview from './components/CryptoOverview'
import useCoins from './hooks/useCoins'
import React, { useState } from 'react'
import { darkTheme, lightTheme } from './Theme'
import { ThemeProvider } from 'styled-components'
import { GlobalStyle } from './GlobalStyle'
import CryptoSearch from './components/CryptoSearch'
import { ToastContainer } from 'react-toastify'

export default function App() {
  const [theme, setTheme] = useState('dark')
  const { coins, setCoins, getCoinById, getStandardCoins, isInList } =
    useCoins()

  return (
    <ThemeProvider theme={theme === 'light' ? lightTheme : darkTheme}>
      <GlobalStyle />
      <ToastContainer
        position="top-right"
        autoClose={3000}
        hideProgressBar={false}
        newestOnTop={false}
        closeOnClick
        rtl={false}
        theme={theme}
        pauseOnFocusLoss={false}
        draggable
        pauseOnHover={false}
      />
      <PageLayout>
        <Header theme={theme} setTheme={setTheme} />
        <CryptoSearch
          setCoins={setCoins}
          getCoinById={getCoinById}
          getDefault={getStandardCoins}
          isInList={isInList}
        />
        <CryptoOverview coins={coins} />
      </PageLayout>
    </ThemeProvider>
  )
}

const PageLayout = styled.div`
  overflow: auto;
  position: fixed;
  height: 100%;
  width: 100%;
  top: 0;
  left: 0;
`

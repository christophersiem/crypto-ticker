import { createGlobalStyle } from 'styled-components'

const GlobalStyle = createGlobalStyle`
  
  * {
    box-sizing: border-box;
  }

  html, body {
    margin: 0;
    background-color: black;
    color: white;
    font-family: 'Share Tech Mono', monospace;
  }

  :root {
    --spacing-s: 8px;
    --spacing-m: 12px;

  }


`

export default GlobalStyle

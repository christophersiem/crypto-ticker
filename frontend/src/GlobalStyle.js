import { createGlobalStyle } from 'styled-components'

export const GlobalStyle = createGlobalStyle`
  
  * {
    box-sizing: border-box;
  }

  html, body {
    margin: 0;
    background: ${({ theme }) => theme.body};
    color: ${({ theme }) => theme.text};
    font-family: 'Share Tech Mono', monospace;
    transition: all 0.50s linear;
  }

  :root {
    --spacing-s: 8px;
    --spacing-m: 12px;
    --spacing-l: 18px;

  }
  
`

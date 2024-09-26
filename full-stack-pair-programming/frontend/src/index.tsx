import ReactDOM from 'react-dom/client';
import { ThemeProvider } from '@emotion/react';
import theme from './theme';
import App from './App';
import './index.css';
const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);

root.render(
  <ThemeProvider theme={theme}>
    <App />
  </ThemeProvider>
);

import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import { Auth0Provider } from '@auth0/auth0-react';

ReactDOM.render(
  <Auth0Provider
    domain={process.env.DOMAIN!}
    clientId={process.env.CLIENTID!}
    authorizationParams={{
      redirect_uri: 'http://localhost:8080/dashboard',
    }}
  >
    <App />
  </Auth0Provider>,
  document.getElementById('root')
);

import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import ListaPessoas from './components/ListaPessoas';
import CadastroPessoa from './components/CadastroPessoa';

function Home() {
  return (
    <div>
      <h1>Cadastro de Pessoas</h1>
      <ul>
        <li><Link to="/listar">Consultar Pessoas</Link></li>
        <li><Link to="/cadastrar">Cadastrar Nova Pessoa</Link></li>
      </ul>
    </div>
  );
}

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/listar" element={<ListaPessoas />} />
        <Route path="/cadastrar" element={<CadastroPessoa />} />
      </Routes>
    </Router>
  );
}

export default App;
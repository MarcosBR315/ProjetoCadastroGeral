import { useEffect, useState } from 'react';
import axios from 'axios';
import * as S from '../globalStyles/globalStyles';

function ListaPessoas() {
  const [pessoas, setPessoas] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/pessoas')
      .then(response => {
        setPessoas(response.data);
      })
      .catch(error => {
        console.error('Erro ao buscar pessoas:', error);
      });
  }, []);

  return (
    <div>
    <S.GlobalStyle/>
      <S.H2>Lista de Pessoas</S.H2>
      <table border="1" cellPadding="8">
        <thead>
          <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Idade</th>
            <th>Email</th>
            <th>Endereço</th>
          </tr>
        </thead>
        <tbody>
          {pessoas.map(pessoa => (
            <tr key={pessoa.id}>
              <td>{pessoa.id}</td>
              <td>{pessoa.nome}</td>
              <td>{pessoa.idade}</td>
              <td>{pessoa.email}</td>
              <td>{pessoa.endereco}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default ListaPessoas;

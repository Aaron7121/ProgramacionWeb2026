import './App.css';

import NavBar from './componentes/NavBar';
import { ThemeProvider } from '@mui/material/styles';
import { Routes, Route } from 'react-router-dom';
import { createTheme } from '@mui/material/styles';
import Home from './paginas/Home';
import About from './paginas/About';
import Post from './paginas/Post';
import DetallesPost from './paginas/DetallesPost';
import CommentsPost from './paginas/CommentsPost';

const darkTheme= createTheme({
  palette: {
    mode: 'dark',
  },
});

function App() {
  return (


    <ThemeProvider theme={darkTheme}>
      <NavBar />

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/about" element={<About />} />
        <Route path="/posts" element={<Post />} />
        <Route path="/posts/:id" element={<DetallesPost />} />
        <Route path="/posts/:id/comments" element={<CommentsPost />} />


      </Routes>
      </ThemeProvider>

  );
}

export default App;
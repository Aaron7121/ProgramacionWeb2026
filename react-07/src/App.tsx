
//import './App.css'
import NavBar from './components/NavBar';
import { Routes, Route } from 'react-router-dom';
import Home from './pages/Home';
import About from './pages/About';
import Posts from './pages/Posts';
import PostDetalle from './pages/PostDetalle';
import { createTheme, ThemeProvider } from '@mui/material';
import Comments from "./pages/Comments.tsx";
import Users from "./pages/Users.tsx";
import UserDetalle from "./pages/UserDetalle.tsx";
import UserPosts from "./pages/UserPosts.tsx";
import ToDos from "./pages/ToDos.tsx";
import Albums from "./pages/Albums.tsx";
import ToDoDetalle from "./pages/ToDoDetalles.tsx";

const darkTheme = createTheme({
  palette: {
    mode: 'light',
  },
});

function App() {


  return (
      <>
        <ThemeProvider theme={darkTheme}>
          <NavBar/>
          <Routes>

              <Route path="/" element={<h1>{<Home/>}</h1>} />
              <Route path="/about" element={<h1>{<About/>}</h1>} />
              <Route path="/posts" element={<h1>{<Posts/>}</h1>} />
              <Route path="/posts/:id" element={<h1>{<PostDetalle/>}</h1>}/>
              <Route path="/posts/:id/comments" element={<h1>{<Comments/>}</h1>}/>
              <Route path="/users" element={<h1>{<Users/>}</h1>}/>
              <Route path="/users/:id" element={<h1>{<UserDetalle/>}</h1>}/>
              <Route path="/users/:id/posts" element={<h1>{<UserPosts/>}</h1>}/>
              <Route path="/users/:id/todos" element={<ToDos />} />
              <Route path="/users/:id/albums" element={<Albums />} />
              <Route path="/todos/:id" element={<ToDoDetalle />} />

          </Routes>
        </ThemeProvider>
      </>
  )
}

export default App
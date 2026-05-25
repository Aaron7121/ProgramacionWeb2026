import {
  Container,
  Typography,
  Button,
  Table,
  TableHead,
  TableRow,
  TableCell,
  TableBody,
} from '@mui/material';
import { useState } from 'react';
import axios from 'axios';
import InfoIcon from '@mui/icons-material/Info';
import { Link } from 'react-router-dom';
interface Post {
  id: number;
  title: string;
  body: string;
}

function Post() {
  const [posts, setPosts] = useState<Post[]>([]);
  const [loading, setLoading] = useState(false);
  const handleClick = () => {


  }
  const fetchPosts = async () => {
    try {
      setLoading(true);

      const response = await axios.get<Post[]>(
        'https://jsonplaceholder.typicode.com/posts'
      );

      setPosts(response.data);
    } catch (error) {
      console.error('Error al cargar posts:', error);
    } finally {
      setLoading(false);
    }
  };




  return (

    <Container sx={{ mt: 4 }}>
      <Typography variant="h4" gutterBottom>
        Posts
      </Typography>

      <Button
        variant="contained"
        color="primary"
        onClick={fetchPosts}
        disabled={loading}
      >
        {loading ? 'Cargando...' : 'Cargar datos'}
      </Button>

      <Table  sx={{
        mt: 2,
        // ensure table cells use black text; includes head/body and any nested content
        '& .MuiTableCell-root': {
          borderBottom: '1px solid #ddd',
          color: 'black',
        },
        '& .MuiTableCell-head': {
          color: 'black',
          fontWeight: 600,
        },
      }}>
        <TableHead>
          <TableRow>
            <TableCell>ID</TableCell>
            <TableCell>Título</TableCell>
            <TableCell>Body</TableCell>
            <TableCell>Acciones</TableCell>
          </TableRow>
        </TableHead>

        <TableBody>
          {posts.map((post) => (
            <TableRow key={post.id}>
              <TableCell>{post.id}</TableCell>
              <TableCell>{post.title}</TableCell>
              <TableCell>{post.body}</TableCell>
              <TableCell>
                <Button color="inherit"
                        component={Link} to={`/posts/${post.id}`} state={{ post }} startIcon={<InfoIcon />}>
                  Detalles
                </Button>

              </TableCell>


            </TableRow>
          ))}
        </TableBody>
      </Table>
    </Container>

  );
}

export default Post;
import { useState, useEffect } from 'react';
import axios from 'axios';
import { useParams, useLocation, Link } from 'react-router-dom';
import { Container, Typography, Button, CircularProgress } from '@mui/material';
import Box from '@mui/material/Box';
import { ThemeProvider } from '@mui/material/styles';
import { createTheme } from '@mui/material/styles';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';

interface Post {
    id: number;
    title: string;
    body: string;
}
interface Comment {
    id: number;
    name: string;
    email: string;
    body: string;
}
function CommentsPost () {


    const darkTheme= createTheme({
        palette: {
            mode: 'dark',
        },
    });
    const params = useParams();
    const id = params.id; // string | undefined
    const location = useLocation();

    // try to read the post (optional) passed via Link state
    const statePost = (location.state as any)?.post as Post | undefined;


    const post = statePost ?? null;
    const [comments, setComments] = useState<Comment[]>([]);

    const [loading, setLoading] = useState(false);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        // fetch comments when id changes
        if (id) {
            fetchCommentsByPostId(id);
        }
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [id]);

    const fetchCommentsByPostId = async (postId: string) => {
        try {
            setLoading(true);
            setError(null);
            const response = await axios.get<Comment[]>(
                `https://jsonplaceholder.typicode.com/posts/${postId}/comments`
            );
            setComments(response.data);
        } catch (err) {
            console.error('Error al cargar los comentarios:', err);
            setError('No se pudieron cargar los comentarios.');
        } finally {
            setLoading(false);
        }
    };



    return (
    <ThemeProvider theme={darkTheme}>
    <Container sx={{ mt: 4 }}>
      <Typography variant="h4" gutterBottom>Comentarios del Post</Typography>

      {!id && (
        <>
          <Typography>Id del post no especificado en la URL.</Typography>
          <Button component={Link} to="/posts" sx={{ mt: 2 }} variant="contained">Volver a posts</Button>
        </>
      )}

      {loading && <CircularProgress />}

      {!loading && error && (
        <Typography color="error">{error}</Typography>
      )}

      {!loading && !error && (
        <Box sx={{ mt: 2, display: 'flex', flexDirection: 'column', gap: 2 }}>
          {post && (
            <Card>
              <CardContent>
                <Typography variant="h6">{post.title}</Typography>
                <Typography sx={{ mt: 1 }}>{post.body}</Typography>
              </CardContent>
            </Card>
          )}

          {comments.length === 0 && (
            <Typography>No hay comentarios para este post.</Typography>
          )}

          {comments.map((c) => (
            <Card key={c.id}>
              <CardContent>
                <Typography variant="subtitle1">{c.name} <Typography component="span" sx={{ ml: 1, color: 'gray' }}>({c.email})</Typography></Typography>
                <Typography sx={{ mt: 1 }}>{c.body}</Typography>
              </CardContent>
            </Card>
          ))}

          <Button component={Link} to="/posts" sx={{ mt: 2 }} variant="outlined">Volver a posts</Button>
        </Box>
      )}

    </Container>
    </ThemeProvider>
  );
}
export default CommentsPost;
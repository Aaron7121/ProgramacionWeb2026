import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useParams, useLocation, Link } from 'react-router-dom';
import { Container, Typography, Button, CircularProgress } from '@mui/material';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { ThemeProvider } from '@mui/material/styles';
import { createTheme } from '@mui/material/styles';
import Card from '@mui/material/Card';



interface Post {
    id: number;
    title: string;
    body: string;
}

function DetallesPost(){

    const darkTheme= createTheme({
        palette: {
            mode: 'dark',
        },
    });
    const params = useParams();
    const id = params.id; // string | undefined
    const location = useLocation();

    // try to read the post passed via Link state
    const statePost = (location.state as any)?.post as Post | undefined;

    const [post, setPost] = useState<Post | null>(statePost ?? null);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        // if we already have the post from state, no need to fetch
        if (!post && id) {
            fetchPostById(id);
        }
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [id]);

    const fetchPostById = async (postId: string) => {
        try {
            setLoading(true);
            setError(null);
            const response = await axios.get<Post>(
                `https://jsonplaceholder.typicode.com/posts/${postId}`
            );
            setPost(response.data);
        } catch (err) {
            console.error('Error al cargar el post:', err);
            setError('No se pudo cargar el detalle.');
        } finally {
            setLoading(false);
        }
    };

    return(



        <Container sx={{ mt: 2, position: "relative" ,mb: 2}}>

            <div>asdasdasd</div>
            <ThemeProvider theme={darkTheme}>
                <Card sx={{ maxWidth: 345 , mt: 4
                    ,m:2}}>
            <Box

                color="primary"
                component="form"
                sx={{ '& > :not(style)': { m: 1, width: '25ch' } }}
                noValidate
                autoComplete="off"
            >
                <TextField multiline defaultValue={post.id} focused id="outlined-basic" label="Id" variant="outlined" > asd</TextField>
                <p></p>

                <TextField multiline defaultValue={post.title} focused id="filled-basic" label="Title" variant="outlined" />
                <p></p>
                <TextField multiline defaultValue={post.body} focused id="standard-basic" label="Body" variant="outlined" />
            </Box>
                </Card>
            </ThemeProvider>
            <Button component={Link} to="/posts" sx={{ mt: 3 }} variant="outlined">Volver</Button>
            <Button component={Link} to={`/posts/${post.id}/comments`}sx={{ mt: 3 }} variant="outlined">Ver Comentarios</Button>





        </Container>

    )

}

export default DetallesPost;
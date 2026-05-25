import { Container, Typography } from '@mui/material';

function Home(){

    return(
        <>
        <Container sx={{ mt: 4 }}>
            <Typography variant="h4">Bienvenido</Typography>
            <Typography variant="h6">Aplicacion para consultar posts</Typography>
        </Container>
        </>
        )
    }
export default Home;
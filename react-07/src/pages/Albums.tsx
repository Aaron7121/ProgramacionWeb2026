import { useEffect, useState } from "react";
import { useParams, Link } from "react-router-dom";
import axios from "axios";

import type { Album } from "../models/Album";

import {
    Container,
    Typography,
    Card,
    CardContent,
    Button,
    Box
} from "@mui/material";

function Albums() {

    const { id } = useParams<{ id: string }>();

    const [albums, setAlbums] = useState<Album[]>([]);

    useEffect(() => {

        axios
            .get<Album[]>(
                `https://jsonplaceholder.typicode.com/albums?userId=${id}`
            )
            .then(response => setAlbums(response.data))
            .catch(error => alert("Error: " + error));

    }, [id]);

    return (

        <Container sx={{ mt: 4 }}>

            <Box
                sx={{
                    display: "flex",
                    justifyContent: "space-between",
                    alignItems: "center",
                    mb: 3
                }}
            >

                <Typography variant="h4">
                    Albums del Usuario {id}
                </Typography>

                <Button
                    variant="outlined"
                    component={Link}
                    to="/users"
                >
                    Regresar
                </Button>

            </Box>

            {
                albums.map(album => (

                    <Card
                        key={album.id}
                        sx={{ mb: 2 }}
                    >

                        <CardContent>

                            <Typography
                                variant="h6"
                                sx={{ fontWeight: "bold" }}
                            >
                                Album #{album.id}
                            </Typography>

                            <Typography
                                variant="body1"
                                color="text.secondary"
                            >
                                {album.title}
                            </Typography>

                        </CardContent>

                    </Card>
                ))
            }

        </Container>
    );
}

export default Albums;
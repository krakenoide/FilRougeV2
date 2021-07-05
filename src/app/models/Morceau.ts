import { Album } from "./Album";
import { Artiste } from "./Artiste";

export interface Morceau {
    id?: number;
    nomArtiste: string;
    artiste: Artiste;
    nomAlbum: string;
    album: Album;
    nomMorceau: string;
}
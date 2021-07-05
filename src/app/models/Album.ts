import { Byte } from "@angular/compiler/src/util";
import { Artiste } from "./Artiste";

export interface Album {
    id?: number;
    nomAlbum: string;
    artiste: Artiste;
    couverture: Byte;
}
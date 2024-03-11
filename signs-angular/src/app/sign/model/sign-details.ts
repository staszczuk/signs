import {Signtype} from "../../signtype/model/signtype";

export interface SignDetails {
  id: string;
  color: string;
  name: string;
  shape: string;
  signType: Signtype;
}

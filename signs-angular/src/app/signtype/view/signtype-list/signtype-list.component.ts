import { Component } from '@angular/core';
import {SignTypeService} from "../../service/signtype.service";
import {SignTypes} from "../../model/signtypes";
import {Signtype} from "../../model/signtype";

@Component({
  selector: 'app-signtype-list',
  templateUrl: './signtype-list.component.html',
  styleUrl: './signtype-list.component.css'
})
export class SigntypeListComponent {
  constructor(private service: SignTypeService) {

  }

  signTypes: SignTypes | undefined;

  ngOnInit(): void {
    this.service.getSignTypes().subscribe(signTypes => this.signTypes = signTypes);
  }

  onDelete(signType: Signtype): void {
    this.service.deleteSignType(signType.id).subscribe(() => this.ngOnInit());
  }
}

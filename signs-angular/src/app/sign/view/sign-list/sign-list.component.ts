import {Component, OnInit} from '@angular/core';
import {SignService} from "../../service/sign.service";
import {Signs} from "../../model/signs";
import {Sign} from "../../model/sign";

@Component({
  selector: 'app-sign-list',
  templateUrl: './sign-list.component.html',
  styleUrls: ['./sign-list.component.css']
})
export class SignListComponent implements OnInit {
  constructor(private service: SignService) {

  }

  signs: Signs | undefined;

  ngOnInit(): void {
    this.service.getSigns().subscribe(signs => this.signs = signs);
  }

  onDelete(sign: Sign): void {
    this.service.deleteSign(sign.id).subscribe(() => this.ngOnInit());
  }
}

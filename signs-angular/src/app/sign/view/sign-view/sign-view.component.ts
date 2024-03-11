import {Component, OnInit} from '@angular/core';
import {SignService} from "../../service/sign.service";
import {ActivatedRoute, Router} from "@angular/router";
import {SignDetails} from "../../model/sign-details";

@Component({
  selector: 'app-sign-view',
  templateUrl: './sign-view.component.html',
  styleUrls: ['./sign-view.component.css']
})
export class SignViewComponent implements OnInit {
  sign: SignDetails | undefined;

  constructor(private service: SignService, private route: ActivatedRoute, private router: Router) {

  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getSign(params['uuid'])
        .subscribe(sign => this.sign = sign)
    });
  }

}

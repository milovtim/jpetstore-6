import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {forkJoin} from "rxjs/observable/forkJoin";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Petshop';
  catItems: any = [];
  catColumns = [
    { prop: 'categoryId' },
    { name: 'name' },
    { name: 'description' }
  ];
  prodItems: any = [];
  prodColumns = [
    { prop: 'productId' },
    { prop: 'categoryId' },
    { name: 'name' },
    { name: 'description' }
  ];



  constructor(private httpClient: HttpClient) {}

  ngOnInit(): void {
    forkJoin(
      this.httpClient.get('http://localhost:8080/ajax/cat-list'),
      this.httpClient.get('http://localhost:8080/ajax/prod-list?cat-id=FISH'),
    ).subscribe(data => {
      this.catItems = data[0];
      this.prodItems = data[1];
    })
  }
}

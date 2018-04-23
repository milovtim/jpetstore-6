import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import "rxjs/add/observable/empty";
import {environment} from "../environments/environment";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public static API_URL = environment.apiUrl;

  @ViewChild('prodDataTable') prodDataTable: any;

  title = 'Petshop';
  catItems: Array<any> = [];
  catColumns = [
    { prop: 'categoryId' },
    { name: 'name' },
    { name: 'description' }
  ];
  prodItems: Array<any> = [];

  private selectedCat: string;
  catAddModal: boolean;//для переключения режима модального окна: сохранить кат-ю или продукт

  constructor(private httpClient: HttpClient,
              private modalService: BsModalService) {}

  ngOnInit(): void {
    this.loadCatItems();
  }

  private loadCatItems(): void {
    this.httpClient.get(`${AppComponent.API_URL}/cat`)
      .subscribe(data => {
        this.catItems = data as Array<any>;
      });
  }

  private loadProdItems(): void {
    this.httpClient.get(`${AppComponent.API_URL}/cat/${this.selectedCat}/prod`)
      .subscribe(data => this.prodItems = data as Array<any>);
  }

  selectCat({selected}) {
    let catId = selected[0].categoryId;
    if (catId) {
      this.selectedCat = catId;
      this.loadProdItems();
    }
  }


  private modalRef: BsModalRef;

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }

  saveCat(name, descr) {
    console.log(`save category: ${name}, ${descr}`);

    this.httpClient.post(`${AppComponent.API_URL}/cat`, {"name": name, "description": descr})
      .subscribe(data => {
        if (data) {
          this.modalRef.hide();
          this.loadCatItems();
        }
      }, error => console.log(error));
  }

  saveProd(name: String, descr: String) {
    console.log(`save product: ${name}, ${descr}`);

    this.httpClient
      .post(`${AppComponent.API_URL}/prod`, {"categoryId": this.selectedCat, "name": name, "description": descr})
      .subscribe(data => {
        if (data) {
          this.modalRef.hide();
          this.loadProdItems();
        }
      }, error => console.log(error));
  }

  toggleExpandRow(row) {
    this.prodDataTable.rowDetail.toggleExpandRow(row);
  }

  editProd(prodId: number, name: string, descr: string) {
    if (prodId && !isNaN(+prodId)) {
      let productId = Number(prodId);
      console.log(`Update product ${productId}`);
      this.httpClient.post(`${AppComponent.API_URL}/prod/edit/${productId}`, {"name": name, "description": descr})
        .subscribe(() => this.loadProdItems());
    }
  }
}

import {
  Component, DoCheck, IterableDiffer, IterableDiffers, OnChanges, OnInit, SimpleChanges,
  TemplateRef
} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Observable} from "rxjs/Observable";
import "rxjs/add/observable/empty";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, OnChanges, DoCheck {

  title = 'Petshop';

  catItems: Array<any> = [];
  catColumns = [
    { prop: 'categoryId' },
    { name: 'name' },
    { name: 'description' }
  ];
  prodItems: any = [];
  prodColumns = [
    { prop: 'productId', "flexGrow": 1 },
    { prop: 'categoryId', "flexGrow": 1 },
    { prop: 'name', "flexGrow": 2 },
    { prop: 'description', "flexGrow": 3 }
  ];

  private selectedCat: string;
  private catDiffer: IterableDiffer<any>;

  constructor(private httpClient: HttpClient,
              private iterDiffers: IterableDiffers,
              private modalService: BsModalService) {
    this.catDiffer = this.iterDiffers.find(this.catItems).create((index, item: any) => item.categoryId);
  }

  ngOnInit(): void {
    this.httpClient.get('http://localhost:8080/ajax/cat')
      .subscribe(data => {
        this.catItems = data as Array<any>;
      });
  }

  ngDoCheck(): void {
  }

  ngOnChanges(changes: SimpleChanges): void {
    // let ch = this.catDiffer.diff(this.catItems);
    // if (ch)
    //   ch.forEachAddedItem(record => console.log(record));
  }

  selectCat({selected}) {
    let catId = selected[0].categoryId;
    if (catId) {
      this.selectedCat = catId;
      this.httpClient.get('http://localhost:8080/ajax/prod-list', {params: {'cat-id': catId}})
        .subscribe(data => this.prodItems = data);
    }
  }


  private modalRef: BsModalRef;

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
    // this.addCatArrItem({ 'categoryId': "fake", name: 'name fake', 'description': "descr fake" });
  }

  saveCat(name, descr) {
    console.log(`save category: ${name}, ${descr}`);
    this.httpClient.post('http://localhost:8080/ajax/cat',
      {"name": name, "description": descr},
      {observe: 'body', responseType: 'json'}
    )
      .mergeMap((respBody: any, index) => {
            this.modalRef.hide();
            let newEntityLocation = respBody.location;
            if (newEntityLocation)
              return this.httpClient.get(newEntityLocation);
            else
              return Observable.empty<any>();
      })
      .subscribe(data => {
        if (data) {
          this.addCatArrItem(data);
        }
      }, error => console.log(error));
  }

  private addCatArrItem(item) {
    let newArr = this.catItems.slice();
    newArr.push(item);
    this.catItems = newArr;
  }
}

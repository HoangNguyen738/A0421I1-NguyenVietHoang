import { Component, OnInit } from '@angular/core';
import {IWord} from '../iword';
import {DictionaryService} from '../service/dictionary.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css']
})
export class DictionaryDetailComponent implements OnInit {

  dictionary: IWord | undefined;
  constructor(private dictionaryService: DictionaryService, private activatedRouter: ActivatedRoute) { }

  ngOnInit(): void {
    this.activatedRouter.paramMap.subscribe((param) => {
      this.dictionary = this.dictionaryService.translate(param.get('word'));
    });
  }

}

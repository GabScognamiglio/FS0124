import { Component, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-input-form',
  templateUrl: './input-form.component.html',
  styleUrls: ['./input-form.component.scss']
})
export class InputFormComponent {
  @Output() handleData = new EventEmitter<string>();

  getData(event: KeyboardEvent) {
    if (event.key==='Enter') {
      let target = event.target as HTMLInputElement;
      if (target.value != ''){
      }
    }
  }
}

import { Directive, ElementRef, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appRandomTagColor]'
})
export class RandomTagColorDirective {
  background=this.randomColor()


  constructor(private target: ElementRef, private render: Renderer2) {
    this.render.setStyle(this.target.nativeElement, 'backgroundColor', `${this.background}`);
}



  randomColor() {
    const randomNum = Math.floor(Math.random() * 16777215);
    const randomColor = "#" + randomNum.toString(16);
    return randomColor;
  }
  
}

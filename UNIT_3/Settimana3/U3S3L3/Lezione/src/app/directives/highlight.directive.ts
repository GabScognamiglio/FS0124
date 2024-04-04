import { Directive, ElementRef, Renderer2 } from '@angular/core';

@Directive({
    selector: '[appHighlight]',
})
export class HighlightDirective {
    constructor(private target: ElementRef, private render: Renderer2) {
        this.render.setStyle(this.target.nativeElement, 'backgroundColor', 'red');
    }
}

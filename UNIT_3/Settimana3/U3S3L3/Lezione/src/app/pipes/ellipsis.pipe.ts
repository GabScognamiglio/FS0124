import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
    name: 'ellipsis',
})
export class EllipsisPipe implements PipeTransform {
    transform(value: string): string {
        return value.slice(0, 10) + '...';
    }
}

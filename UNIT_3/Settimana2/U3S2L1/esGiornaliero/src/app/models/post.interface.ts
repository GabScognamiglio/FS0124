export interface Post {
    id: number,
    body: string,
    title: string,
    active: boolean,
    tags: string[],
    reactions:number
}

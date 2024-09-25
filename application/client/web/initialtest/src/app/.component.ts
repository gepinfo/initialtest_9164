import { Component, OnInit, ViewChild } from '@angular/core';
import { Service } from './.service';





@Component({
  selector: 'app-',
  templateUrl: './.component.html',
  styleUrls: ['./.component.scss'],
})

export class Component implements OnInit {
    public employee:any = {
        created_date: '',
        created_by: '',
        last_modified_by: '',
        last_modified_date: '',
        emp_reference: '',
        name: '',
        age: '',
    }
    public address:any = {
        created_date: '',
        created_by: '',
        last_modified_by: '',
        last_modified_date: '',
        reference_num: '',
        place: '',
    }




    constructor (
        private Service: Service,
    ) { }

    ngOnInit() {
        this.employee.created_by = sessionStorage.getItem('email') || ''; 
        this.address.created_by = sessionStorage.getItem('email') || ''; 
        


    
    }


}
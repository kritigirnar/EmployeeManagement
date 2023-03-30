package com.developer.employeemanagement.controller;


import com.developer.employeemanagement.dto.request.EmployeeRequest;
import com.developer.employeemanagement.dto.response.EmployeeResponse;
import com.developer.employeemanagement.entity.EmployeeEntity;
import com.developer.employeemanagement.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    RestTemplate restTemplate;

    public RestConsumer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping(value = "/posts")
    public Post[] getProductList() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange("https://jsonplaceholder.typicode.com/posts", HttpMethod.GET, entity, Post[].class).getBody();
    }

    @RequestMapping(value = "/posts/create")
    public String createPost(@RequestBody Post post) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Post> entity = new HttpEntity<Post>(post, httpHeaders);
        return restTemplate.exchange("https://jsonplaceholder.typicode.com/posts", HttpMethod.POST, entity, String.class).getBody();

    }

    @GetMapping
    public List<EmployeeEntity> findAllEmployee() {
        return employeeService.findAllEmployee();
    }

    @GetMapping("/{id}")
    public Optional<EmployeeEntity> findEmployeeById(@PathVariable("id") Long id) {
        return employeeService.findById(id);
    }

    @PostMapping
    public EmployeeEntity saveEmployee(@RequestBody EmployeeEntity employeeEntity) {
        return employeeService.saveEmployee(employeeEntity);
    }

    @PutMapping
    public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity employeeEntity) {
        return employeeService.updateEmployee(employeeEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
    }
    @GetMapping
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees(
                        @RequestParam(defaultValue = "0") Integer pageNo,
                        @RequestParam(defaultValue = "10") Integer pageSize,
                        @RequestParam(defaultValue = "id") String sortBy)
    {
        List<EmployeeEntity> list = service.getAllEmployees(pageNo, pageSize, sortBy);

        return new ResponseEntity<List<EmployeeEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
        throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
          .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        return ResponseEntity.ok().body(employee);
    }

//    Using Request and Response with save and update employee

    @PostMapping("/res")
    public EmployeeResponse saveEmpResponse(@RequestBody EmployeeRequest employeeRequest) {
        return employeeService.saveEmployee(employeeRequest);
    }

    @PutMapping("/res/{id}")
    public EmployeeResponse updateEmpResponse(@RequestBody EmployeeRequest employeeRequest, @PathVariable("id") Long id) {
        return employeeService.updateEmployee(employeeRequest, id);
    }

}

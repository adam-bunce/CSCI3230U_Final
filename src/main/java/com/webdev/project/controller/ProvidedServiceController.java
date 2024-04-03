package com.webdev.project.controller;

import com.webdev.project.model.ProvidedService;
import com.webdev.project.service.ProvidedServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/services")
public class ProvidedServiceController {
    ProvidedServiceService serviceService;

    @Autowired
    public ProvidedServiceController(ProvidedServiceService serviceService) {
        super();
        this.serviceService = serviceService;
    }

    @GetMapping("/list")
    public String viewBookings(Model model) {
        model.addAttribute("services", this.serviceService.getAllServices());
        return "/services/list";
    }

    @GetMapping("/create")
    public String viewCreateService(Model model) {
        model.addAttribute("newService", new ProvidedService());
        return "/services/create";
    }

    @PostMapping("/create")
    public String createService(ProvidedService newService, Model model) {
        this.serviceService.saveOrUpdateService(newService);
        return "redirect:/services/list";
    }

    @PostMapping("/delete")
    public String deleteService(Long serviceId, Model model) {
        this.serviceService.deleteByServiceId(serviceId);
        return "redirect:/services/list";
    }

    @GetMapping("/edit/{id}")
    public String viewEditService(@PathVariable Long id, Model model) {
        ProvidedService service = this.serviceService.getServiceById(id);
        model.addAttribute("selectedService", service);

        return "/services/edit";
    }

    @PostMapping("/update")
    public String updateService(ProvidedService service, Model model) {
        this.serviceService.saveOrUpdateService(service);
        return "redirect:/services/list";
    }
}

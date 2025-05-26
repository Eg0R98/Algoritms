package com.stulikov.different;


import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "company-info",
            namespace = "com.geeksforgeeks")
    @XmlAccessorType(XmlAccessType.NONE)
    public class Company {

        // Class data members
        @XmlAttribute(name = "id") private Integer id;
        @XmlElement(name = "company-name")
        private String companyName;

        @XmlElement(name = "ceo-name") private String ceoName;
        @XmlElement(name = "no-emp") private Integer noEmp;

        // Getters and setters
        public Integer getId() { return id; }
        public void setId(Integer id)
        {
            // this keyword refers to current itself
            this.id = id;
        }

        // Getter and Setter
        public String getCompanyName() { return companyName; }
        public void setCompanyName(String companyName)
        {
            this.companyName = companyName;
        }

        // Getter and Setter
        public String getCeoName() { return ceoName; }
        public void setCeoName(String ceoName)
        {
            this.ceoName = ceoName;
        }

        // Getter and Setter
        public Integer getNoEmp() { return noEmp; }
        public void setNoEmp(Integer noEmp)
        {
            this.noEmp = noEmp;
        }
    }


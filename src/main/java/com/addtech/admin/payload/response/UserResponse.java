package com.addtech.admin.payload.response;

import com.addtech.admin.payload.Pageable;
import com.addtech.admin.payload.Sort;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class UserResponse {
    private List<Content> content;
    private int totalPages;
    private long totalElements;
    private boolean first;
    private boolean last;
    private Pageable pageable;
    private int size;
    private int number;
    private Sort sort;
    private int numberOfElements;
    private boolean empty;

    // Getters and Setters

    public List<Content> getContent() {
        return content;
    }

    public void setContent(List<Content> content) {
        this.content = content;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public Pageable getPageable() {
        return pageable;
    }

    public void setPageable(Pageable pageable) {
        this.pageable = pageable;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public static class Content {
        private UUID id;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private String pin;
        private String fullName;
        private String position;
        private String role;
        private String unstructuredName;
        private BigInteger serialNumber;
        private String status;
        List<OrganizationResponses> organizations;

        public void setId(UUID id) {
            this.id = id;
        }

        public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
        }

        public void setUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
        }

        public void setPin(String pin) {
            this.pin = pin;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public void setUnstructuredName(String unstructuredName) {
            this.unstructuredName = unstructuredName;
        }

        public void setSerialNumber(BigInteger serialNumber) {
            this.serialNumber = serialNumber;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setOrganizations(List<OrganizationResponses> organizations) {
            this.organizations = organizations;
        }

        public UUID getId() {
            return id;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        public LocalDateTime getUpdatedAt() {
            return updatedAt;
        }

        public String getPin() {
            return pin;
        }

        public String getFullName() {
            return fullName;
        }

        public String getPosition() {
            return position;
        }

        public String getRole() {
            return role;
        }

        public String getUnstructuredName() {
            return unstructuredName;
        }

        public BigInteger getSerialNumber() {
            return serialNumber;
        }

        public String getStatus() {
            return status;
        }

        public List<OrganizationResponses> getOrganizations() {
            return organizations;
        }

        public static class OrganizationResponses {
            private UUID id;
            private LocalDateTime createdAt;
            private LocalDateTime updatedAt;
            private String name;
            private String inn;
            private String status;

            // Getters and Setters

            public void setId(UUID id) {
                this.id = id;
            }

            public void setCreatedAt(LocalDateTime createdAt) {
                this.createdAt = createdAt;
            }

            public void setUpdatedAt(LocalDateTime updatedAt) {
                this.updatedAt = updatedAt;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setInn(String inn) {
                this.inn = inn;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public UUID getId() {
                return id;
            }

            public LocalDateTime getCreatedAt() {
                return createdAt;
            }

            public LocalDateTime getUpdatedAt() {
                return updatedAt;
            }

            public String getName() {
                return name;
            }

            public String getInn() {
                return inn;
            }

            public String getStatus() {
                return status;
            }
        }


        public static class Pageable {
            private int pageNumber;
            private int pageSize;
            private long offset;
            private Sort sort;
            private boolean unpaged;
            private boolean paged;

            // Getters and Setters

            public int getPageNumber() {
                return pageNumber;
            }

            public void setPageNumber(int pageNumber) {
                this.pageNumber = pageNumber;
            }

            public int getPageSize() {
                return pageSize;
            }

            public void setPageSize(int pageSize) {
                this.pageSize = pageSize;
            }

            public long getOffset() {
                return offset;
            }

            public void setOffset(long offset) {
                this.offset = offset;
            }

            public Sort getSort() {
                return sort;
            }

            public void setSort(Sort sort) {
                this.sort = sort;
            }

            public boolean isUnpaged() {
                return unpaged;
            }

            public void setUnpaged(boolean unpaged) {
                this.unpaged = unpaged;
            }

            public boolean isPaged() {
                return paged;
            }

            public void setPaged(boolean paged) {
                this.paged = paged;
            }
        }

        public static class Sort {
            private boolean sorted;
            private boolean empty;
            private boolean unsorted;

            // Getters and Setters

            public boolean isSorted() {
                return sorted;
            }

            public void setSorted(boolean sorted) {
                this.sorted = sorted;
            }

            public boolean isEmpty() {
                return empty;
            }

            public void setEmpty(boolean empty) {
                this.empty = empty;
            }

            public boolean isUnsorted() {
                return unsorted;
            }

            public void setUnsorted(boolean unsorted) {
                this.unsorted = unsorted;
            }
        }
    }
}

